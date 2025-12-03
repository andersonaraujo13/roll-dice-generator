-- Executar Container
- docker run <image>

-- Executar e Nomear Container
- docker run --name <name> <image>

-- Executar Iterativo Container
- docker run -it <image>

-- Executar Backgroud
- docker run -d <image>

-- Executar Exportando Portas
- docker run -d -p <porta_externa>:<porta_container> <image>
- docker run -d -p 80:80 <image>

-- Acessar Logs 
- docker logs <id/nome>

-- Parar Container
- docker stop <id/nome>

-- Reiniciar Container
- docker start <id/nome>
- docker start -it <id/nome> 

-- Remover Container
- docker -rm <id/nome>
- docker -rm -f <id/nome> (Forcando a remocao)

-- Listar Container
- docker container ls
- docker ps
- docker ps -a
- docker container ls -a (todos os container ja executados)

-- Remover container após execução
- Docker run --rm <d/nome>

-- Copiar arquivos de container
- docker cp (procurar mais depois)
---------------------------------------------------------------------------------

--Criando Imagem

FROM imagem base
WORKDIR diretório da aplicação
EXPOSE porta da aplicação
COPY quais arquivos serão copiados

- docker build <diretório do arquivo dockerfile pode usar so . para executar no atual>

-- Nomeando Imagem
- docker tag <nome>
- docker tag <nome>:<tag>

-- Nomeando Imagem na build
- docker build -t <nome>:<tag> <diretório do arquivo dockerfile pode usar so . para executar no atual> 

-- Nomeando Imagem na build Para mandar para para o hub
- docker build -t <user_hub>/<nome>:<tag> <diretório do arquivo dockerfile pode usar so . para executar no atual> 

-- Removendo Imagens
- docker rmi <id/nome>
- docker rmi -f <id/nome>

-- Limpeza de imagens / container não usados
-Docker system prune


----------------------------------------------------------------------------------

--Docker Hub

-- Login / Logout
- docker login
- docker logout

-- Push 
- docker push <image>

-- Push para o hub
- docker push <user_hub>/<image>