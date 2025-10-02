# CapacityDash - Sistema de Gerenciamento de Frota Mottu

## 📋 Visão Geral
O CapacityDash é uma aplicação web desenvolvida em Spring Boot para gerenciamento e visualização da capacidade da frota de motos Mottu. A aplicação segue o padrão MVC (Model-View-Controller) e oferece uma interface intuitiva para acompanhamento em tempo real.

## 🚀 Tecnologias Utilizadas
- **Backend**: Spring Boot 3.x, Java 17
- **Frontend**: Thymeleaf, Bootstrap
- **Banco de Dados**: PostgreSQL
- **Build Tool**: Maven
- **Segurança**: Spring Security com OAuth2

## ⚡ Execução Local

### Pré-requisitos
- **Java 17** ou superior
- **Maven 3.6+**
- **PostgreSQL** (local ou remoto)
- **Git**

### 1. Clone do Repositório
```bash
git clone https://github.com/FelipeSants08/Capacity-dash-challenger.git
cd Capacity-dash-challenger
```
2. Configuração do Banco de Dados
Edite o arquivo src/main/resources/application.properties:

properties
# Configurações do Banco de Dados
spring.datasource.url=jdbc:postgresql://localhost:5432/capacitydash
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver
spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}

3. Build da Aplicação
```bash
mvn clean package -DskipTests
```
4. Execução
```bash
java -jar target/capacitydash-0.0.1-SNAPSHOT.jar
```
5. Acesso
Abra seu navegador e acesse:

http://localhost:8080

Se quiser testar online:
https://capacitydash-app.azurewebsites.net/
