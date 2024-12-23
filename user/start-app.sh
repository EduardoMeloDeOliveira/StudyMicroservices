#!/bin/bash

# Nome do container PostgreSQL
CONTAINER_NAME="user-ms-container-db"

if docker ps --filter "name=$CONTAINER_NAME" --filter "status=running" | grep -q $CONTAINER_NAME; then
  echo "Container $CONTAINER_NAME está rodando."
else
  echo "Container $CONTAINER_NAME não está rodando. Iniciando..."
  docker start $CONTAINER_NAME
  echo "Container $CONTAINER_NAME iniciado."
fi

# Comando para iniciar a aplicação Spring
echo "Iniciando aplicação Spring Boot..."
./mvnw spring-boot:run


