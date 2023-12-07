# Health Care Web Application - DevOps Showcase

## Project Overview

This project is a demonstration of my DevOps skills, showcasing the setup of a Jenkins server using Terraform. The purpose of this setup is to automate the build, test, and deployment processes for a health care web application.

## Jenkins Server Configuration

### Terraform Script

To set up the Jenkins server, I used Terraform. The Terraform script responsible for configuring the Jenkins server can be found in the `Jenkins-server/jenkinserver.tf` file. This script includes the necessary infrastructure-as-code (IaC) to provision the Jenkins server.

#### Prerequisites

Before running the Terraform script, make sure you have:

- Appropriate AWS credentials configured.
- Terraform installed on your local machine.

#### Running the Terraform Script

Execute the following commands to set up the Jenkins server:

```bash
cd Jenkins-server/
terraform init
terraform apply
