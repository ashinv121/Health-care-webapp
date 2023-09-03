provider "aws" {
  region     = "eu-north-1"
  access_key = var.aws_access_key
  secret_key = var.aws_secret_key
}

variable "aws_access_key" {}
variable "aws_secret_key" {}

#create vpc

resource "aws_vpc" "my-terraform-vpc" {
  cidr_block = "10.10.0.0/16"
  
  tags = {
    Name = "my-terraform"

  }
}


#subnet
resource "aws_subnet" "my-terraform-subnet" {

  vpc_id     = aws_vpc.my-terraform-vpc.id
  cidr_block = "10.10.1.0/24"

  tags = {
    Name = "my-terraform"

  }
}

resource "aws_internet_gateway" "my-terraform-gateway" {
  vpc_id = aws_vpc.my-terraform-vpc.id

 tags = {
    Name = "my-terraform"

  }

}

resource "aws_route_table" "my-terraform-route" {
  
  
  vpc_id = aws_vpc.my-terraform-vpc.id

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.my-terraform-gateway.id
  }
  tags = {
    Name = "my-terraform"
  }

}
resource "aws_route_table_association" "my-terraform-route-table-association" {
  subnet_id      = aws_subnet.my-terraform-subnet.id
  route_table_id = aws_route_table.my-terraform-route.id

}

resource "aws_security_group" "my-terraform-security" {
  name        = "my-terraform-vpc"

  vpc_id      = aws_vpc.my-terraform-vpc.id

  ingress {
    description      = "TLS from VPC"
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    cidr_blocks      = [aws_vpc.my-terraform-vpc.cidr_block]
   
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
  }

}
# Create EC2 instances
resource "aws_instance" "jenkins-server" {
  ami           = "ami-0989fb15ce71ba39e"
  instance_type = "t3.micro"
  subnet_id     = aws_subnet.my-terraform-subnet.id
  key_name      = "ansible"
  vpc_security_group_ids = [aws_security_group.my-terraform-security.id]
  associate_public_ip_address = true  # Add this line to assign a public IP

  tags = {
    Name = "jenkins-server"
  }
}



