import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<List<Computer>> computerTestSets = new ArrayList<>();
    static List<List<Connection>> connectionTestSets = new ArrayList<>();

    public static void main(String[] args) {
        readInput();

        int i = 1;

        for (List<Computer> testsetComputers : computerTestSets) {
            processTestset(testsetComputers, connectionTestSets.get(i - 1), i);
            i++;
        }
    }

    private static void findConnectors(List<Computer> computers, List<Connection> connections) {
        for (Connection connection : connections) {
            Computer from = computers.get(connection.from - 1);
            Computer to = computers.get(connection.to - 1);

            from.connectors.add(to.id);
            to.connectors.add(from.id);
        }
    }

    private static List<Computer> getSortedComputers(List<Computer> computers) {
        List<Computer> numberComputers = new ArrayList<>();

        List<Computer> latencyComputers = new ArrayList<>();

        for (Computer computer : computers) {
            if (computer.connectionInformation > 0) {
                latencyComputers.add(computer);
            } else {
                numberComputers.add(computer);
            }
        }

        latencyComputers.sort(new LatencyComparator());
        numberComputers.sort(new NumberComparator());

        List<Computer> sortedComputers = new ArrayList<>();
        int numberComputersId = 0;
        int latencyComputersId = 0;

        for (int i = 0; i < computers.size(); i++) {
            if (numberComputersId < numberComputers.size() && numberComputers.get(numberComputersId).connectionInformation * (-1) <= i) {
                sortedComputers.add(numberComputers.get(numberComputersId));
                numberComputersId++;
            } else {
                sortedComputers.add(latencyComputers.get(latencyComputersId));
                latencyComputersId++;
            }
        }

        return sortedComputers;
    }


    private static void processTestset(List<Computer> computers, List<Connection> connections, int testcaseId) {
        findConnectors(computers, connections);

        List<Computer> sortedComputers = getSortedComputers(computers);

        List<Integer> saturatedComputers = new ArrayList<>();

        int currentLatency = 0;
        Computer previousComputer = null;

        for (Computer computer : sortedComputers) {
            if (computer.id == 1) {
                saturatedComputers.add(1);
                continue;
            }

            Computer beststSaturatedComputer = getBestSaturatedConnector(computers, sortedComputers, saturatedComputers, computer);
            Connection connection = findMatchingConnection(connections, computer.id, beststSaturatedComputer.id);

            if (computer.connectionInformation > 0) {
                connection.latency = computer.connectionInformation - beststSaturatedComputer.currentLatency;
                currentLatency = computer.connectionInformation;
                previousComputer = null;
            } else {
                if (previousComputer != null && previousComputer.connectionInformation == computer.connectionInformation) {
                    connection.latency = currentLatency - beststSaturatedComputer.currentLatency;
                } else {
                    connection.latency = currentLatency - beststSaturatedComputer.currentLatency + 1;
                    computer.currentLatency = currentLatency + 1;
                    currentLatency = currentLatency + 1;
                    previousComputer = computer;
                }
            }

            saturatedComputers.add(computer.id);
        }

        System.out.print("Case #" + testcaseId + ":");

        for (Connection connection : connections) {
            System.out.print(" " + connection.latency);
        }

        System.out.println();
    }

    private static Computer getBestSaturatedConnector(List<Computer> computers, List<Computer> sortedComputers, List<Integer> saturatedComputers, Computer computer) {
        int bestSaturatedConnectorRank = 1001;

        for (int connector : computer.connectors) {
            if (saturatedComputers.contains(connector)) {
                Computer connectorComputor = computers.get(connector - 1);

                if (connectorComputor.connectionInformation != computer.connectionInformation) {

                    int connectorRank = sortedComputers.indexOf(connectorComputor) + 1;

                    if (connectorRank < bestSaturatedConnectorRank) {
                        bestSaturatedConnectorRank = connectorRank;
                    }
                }
            }
        }

        return sortedComputers.get(bestSaturatedConnectorRank - 1);
    }

    private static Connection findMatchingConnection(List<Connection> connections, int id1, int id2) {
        for (Connection connection : connections) {
            if (isMatchingConnection(connection, id1, id2)) {
                return connection;
            }
        }

        return null;
    }

    private static boolean isMatchingConnection(Connection connection, int id1, int id2) {
        return (connection.from == id1 && connection.to == id2) || (connection.from == id2 && connection.to == id1);
    }


    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                int numberOfComputers = Integer.parseInt(fractals[0]);
                int numberOfConnections = Integer.parseInt(fractals[1]);

                parseComputers(numberOfComputers);
                parseConnections(numberOfConnections);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }

    private static void parseComputers(int numberOfComputers) throws IOException {
        String line;
        line = in.readLine();
        String[] fractals = line.split(" ");

        List<Computer> testSetComputers = new ArrayList<>();

        Computer firstComputer = new Computer();
        firstComputer.id = 1;
        firstComputer.connectionInformation = 0;

        testSetComputers.add(firstComputer);

        for (int computerCount = 2; computerCount <= numberOfComputers; computerCount++) {
            int connectionInformation = Integer.parseInt(fractals[computerCount - 2]);

            Computer computer = new Computer();
            computer.id = computerCount;
            computer.connectionInformation = connectionInformation;

            if (connectionInformation > 0) {
                computer.currentLatency = connectionInformation;
            }

            testSetComputers.add(computer);
        }

        computerTestSets.add(testSetComputers);
    }

    private static void parseConnections(int numberOfConnections) throws IOException {
        String line;
        List<Connection> testSetConnections = new ArrayList<>();

        for (int connectionCount = 0; connectionCount < numberOfConnections; connectionCount++) {
            line = in.readLine();
            String[] fractals = line.split(" ");

            Connection connection = new Connection();
            connection.id = connectionCount;
            connection.from = Integer.parseInt(fractals[0]);
            connection.to = Integer.parseInt(fractals[1]);

            testSetConnections.add(connection);
        }

        connectionTestSets.add(testSetConnections);
    }

    private static class Computer {
        int id;
        int connectionInformation;
        List<Integer> connectors = new ArrayList<>();
        int currentLatency = 0;
    }

    private static class Connection {
        int id;
        int from;
        int to;
        int latency = 999999;
    }

    static class NumberComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer a, Computer b) {
            return Integer.compare(b.connectionInformation, a.connectionInformation);
        }
    }

    static class LatencyComparator implements Comparator<Computer> {
        @Override
        public int compare(Computer a, Computer b) {
            return Integer.compare(a.connectionInformation, b.connectionInformation);
        }
    }
}
