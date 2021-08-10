terraform {
  backend "s3" {
    bucket  = "league-cc"
    key     = "terraform.tfstate"
    region  = "eu-central-1"
    profile = "codecool"
    dynamodb_table = "league"
    encrypt = true
  }
}
