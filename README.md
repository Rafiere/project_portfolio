# Features (Explicar)

## Aplicação dividida entre contextos do negócio

## Um controller por feature, para garantir uma melhor testabilidade e organização do código

## Service em quase todas as features, para garantir que, se o projeto escalar e novas regras de negócio surgirem, o service
## já estará pronto para garantir a implementação dessas regras

## A maioria das regras de negócio relacionadas ao domínio, estarão dentro do domínio.

## Os métodos do domínio possuem interfaces fluentes, possibilitando o encadeamento

## A utilização de "final" garante a imutabilidade.