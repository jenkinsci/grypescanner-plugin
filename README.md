# Grype vulnerability scanner

## Introduction

[Grype](https://github.com/anchore/grype) is a vulnerability scanner for container images and filesystems.
This jenkins plugin scans a given target and saves a report as job artifact.
Starting from version 1.7, the grype plugin can be integrated with the [Warnings Next Generation plugin](https://plugins.jenkins.io/warnings-ng/) (minimal version: 10.3.0).

<img src="images/grypeRes.png" alt="Grype plugin" />

## Getting started
This jenkins plugin installs grype in the job workspace directory and performs scan.
See section [Installation/Recommended](https://github.com/anchore/grype) for more installation details.

#### Grype as a build step:
<img src="images/1.png" alt="Grype plugin" />

<img src="images/2.png" alt="Grype plugin" />

#### Possible scan targets:
<img src="images/3.png" alt="Grype plugin" />

#### Configure [Warnings Next Generation plugin](https://plugins.jenkins.io/warnings-ng/):
<img src="images/grypeWarnings.png" alt="Grype plugin" />

#### Scan result report as job artifact:
<img src="images/4.png" alt="Grype plugin" />

#### Scan results:
<img src="images/5.png" alt="Grype plugin" />

<img src="images/6.png" alt="Grype plugin" />

### Usage in a pipeline:
```groovy
pipeline
{
  agent any
  options
  {
    skipStagesAfterUnstable()
  }
  stages
  {
    stage('Build')
    {
      steps
      {
        grypeScan scanDest: 'dir:/tmp', repName: 'myScanResult.txt', autoInstall:true
      }
    }
  }
}
```


#### Acknowledgments
Thanks to Patrick Röder and Thomas Spicker for contributions and creative input!


## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)

