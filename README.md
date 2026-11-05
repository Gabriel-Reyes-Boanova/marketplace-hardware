# Marketplace Full Stack

Marketplace didático com Java 21, Spring Boot, React, PostgreSQL, Flyway e Docker.

## Estrutura

- `backend/`: API REST Spring Boot.
- `frontend/`: aplicação React com Vite.
- `docker-compose.yml`: PostgreSQL, backend e frontend.

## Pré-requisitos

- Docker Desktop com Docker Compose
- Git
- (Opcional para desenvolvimento fora do Docker) JDK 21, Maven e Node.js 22+

## Executar tudo

Na raiz do projeto:

```bash
docker compose up --build
```

- Frontend: http://localhost:5173
- Backend: http://localhost:8080
- Actuator health: http://localhost:8080/actuator/health
- PostgreSQL: localhost:5432

Para encerrar:

```bash
docker compose down
```

Para apagar também os dados locais do PostgreSQL:

```bash
docker compose down -v
```

## Banco de dados

O Flyway executa as migrations automaticamente quando o backend inicia.
Não use `spring.jpa.hibernate.ddl-auto=update` junto com migrations. O projeto usa `validate`:
o Hibernate valida o mapeamento, enquanto o Flyway controla a estrutura do banco.

## Configuração

As credenciais locais do Compose estão no `docker-compose.yml` para facilitar o primeiro
uso. Antes de publicar em um ambiente real, substitua-as por secrets/variáveis de ambiente
e nunca versione credenciais reais.

## Próximas etapas sugeridas

1. Implementar entidades e repositórios.
2. Implementar cadastro/login e autenticação JWT.
3. Implementar autorização por ADMIN, SELLER e CUSTOMER.
4. Criar integração com uma API pública de catálogo.
5. Criar fluxo de importação de produto para a loja.
6. Criar carrinho e compra simulada.
7. Criar testes unitários e de integração.
