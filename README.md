# GPT-Java-GCJ-Dataset
<a name="readme-top"></a>

<br />
<div align="center">
  <a href="https://github.com/tipaek/GPT-Java-GCJ-Dataset">
    <img src="https://cdn.iconscout.com/icon/free/png-256/free-java-file-51-775447.png" alt="logo of Java file" width="80" height="80">

  </a>

  <h3 align="center">GPT Java GCJ Source Code Dataset</h3>

  <p align="center">
    A dataset composed of 76,089 total Java source code files from over 1,000 authors in the 2020 Google Code Jam competition and GPT-4o rewritten code for code generation detection.
    <br />
    <a href="https://github.com/tipaek/GPT-Java-GCJ-Dataset"><strong>Explore the files »</strong></a>
    <br />
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#composition">File Composition</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
With the release of OpenAI's ChatGPT, code written by GPT is becoming increasingly more common in everyday usage. However, students often use generated code to cheat on exams and homework. Being able to detect code written by GPT could be useful for organizations and schools as a classification or anomaly detection task. I previously created the first ever [dataset](https://github.com/tipaek/GPT-Java-Dataset) for this purpose with the GPT-rewritten task which aims to solve the different author styles resulting from different prompts. This is a significantly upscaled version of the last using the 2020 Google Code Jam dataset.

Here's the general idea:
* **58,524 human-authored** Java source code files from over **1,000 participants** were retrieved from the 2020 Google Code Jam competition
* **17,565 of these files were rewritten by GPT-4o** with the prompt: "This is java code. Rewrite it entirely while maintaining functionality."
* Both the original and rewritten files are present in the final dataset to increase difficulty
*The **rewriting task** simulates different GPT-4o coding styles by passing in a variety of contexts that emulate the model's ability to have differing outputs depending on the prompt

This dataset serves aims to be a resource for researchers focusing on AI-generated code detection, providing a practical way to gauge real-world capability.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Composition

Here's a breakdown of the files in this dataset:
* 76,089 total files
* 58,524 files of original authors from the 2020 Google Code Jam
* 17,565 rewritten files using GPT-4o

<!-- USAGE -->
## Usage

Researchers can use this dataset to:

- Evaluate the performance and accuracy of models in detecting GPT-4o under various prompts
- Build new datasets using this as a base 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Timothy Paek - [LinkedIn](https://www.linkedin.com/in/timothy-paek/) - tipaek@syr.edu

Project Link: [https://github.com/tipaek/GPT-Java-GCJ-Dataset](https://github.com/tipaek/GPT-Java-GCJ-Dataset)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Thanks to the participants of the 2020 Google Code Jam competition and [Jur1cek](https://github.com/Jur1cek/gcj-dataset) for making the creation of this dataset possible.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
