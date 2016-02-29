# docker
A collection of docker related stuff

-- Provision a docker node called 'machine-ec2' using the AWS driver (-d amazonec2) on the eu-west-1 region and the vpc-fbebd09e VPC
-- assumes ~/aws/credentials file contains AWS access id and secret key
-- assumes the user associated with these credentials has sufficient permissions (e.g. administrator on ec2)
docker-machine create -d amazonec2 --amazonec2-vpc-id vpc-fbebd09e --amazonec2-region eu-west-1 machine-ec2

--NB: You may need to edit the inbound rules for the associated security group on ec2
-- e.g: Add All ICMP to enable "ping"
-- e.g: Add HTTP (hardcoded to port 80) or All TCP to specify suitable port range

-- list docker machines/nodes
docker-machine ls
