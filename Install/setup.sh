#!/bin/bash
#for Ubuntu

sudo apt-get install postgresql -y 

sudo -u postgres bash -c "psql -c \"ALTER USER postgres WITH PASSWORD 'root_123'\""


