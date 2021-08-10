resource "aws_db_instance" "league-db" {
  identifier             = "league-db"
  name                   = "league-db"
  instance_class         = "db.t3.micro"
  allocated_storage      = 5
  engine                 = "postgres"
  engine_version         = "13.1"
  username               = "admin"
  password               = var.db_password
  db_subnet_group_name   = aws_db_subnet_group.league-subnetgroup.name
  vpc_security_group_ids = [aws_security_group.league-sg.id]
  publicly_accessible    = true
  skip_final_snapshot    = true

}
