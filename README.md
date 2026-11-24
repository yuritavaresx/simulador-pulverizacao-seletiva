# Simulador de Pulverização Seletiva

Protótipo em Java, rodando no console, que compara a pulverização de herbicida no talhão inteiro com a pulverização só onde existe erva daninha.

## Problema

Na aplicação convencional, o herbicida é aplicado no talhão inteiro, mesmo quando a erva daninha aparece só em algumas manchas. Isso gasta produto (e dinheiro) em áreas onde ele não era necessário.

## Como funciona

1. O talhão é representado por uma matriz de células de 10 m x 10 m (100 m² cada).
2. Cada célula é `SOLO`, `CULTURA` ou `ERVA_DANINHA`.
3. O programa mostra o mapa do talhão no console.
4. Simula a **pulverização total**: aplica em todas as células.
5. Simula a **pulverização seletiva**: aplica só nas células com erva daninha.
6. Mostra o mapa depois de cada aplicação, marcando com `*` onde aplicou.
7. Compara as duas: células pulverizadas, área em hectares, litros de calda, custo em R$ e economia em %.

## Conceitos de POO aplicados

- **Enum com atributo e construtor**: `TipoCelula` guarda o símbolo de cada tipo de célula.
- **Encapsulamento**: atributos `private` com getters em `Talhao` e `ResultadoAplicacao` (sem setters).
- **Composição**: `Pulverizador` tem uma `EstrategiaPulverizacao`.
- **Interface e polimorfismo**: `PulverizacaoTotal` e `PulverizacaoSeletiva` implementam `EstrategiaPulverizacao`, e o `Pulverizador` funciona com qualquer uma delas.
- **Constantes e membros estáticos**: `Talhao` (área da célula), `Pulverizador` (litros por célula e preço) e `ImpressoraMapa` (símbolo de pulverizado).

## Estrutura de pacotes

```
src/
├─ application/
│   └─ Program.java
├─ ui/
│   └─ ImpressoraMapa.java
└─ model/
    ├─ enums/
    │   └─ TipoCelula.java
    ├─ entities/
    │   ├─ Talhao.java
    │   └─ ResultadoAplicacao.java
    └─ services/
        ├─ EstrategiaPulverizacao.java   (interface)
        ├─ PulverizacaoTotal.java
        ├─ PulverizacaoSeletiva.java
        └─ Pulverizador.java
```

## Como rodar

Requisito: JDK instalado (testado com o JDK 25).

### Pelo IntelliJ IDEA

1. Abra a pasta do projeto no IntelliJ (`File > Open`).
2. Abra `src/application/Program.java`.
3. Clique no botão ▶ ao lado do método `main`.

### Pelo terminal (PowerShell, a partir da raiz do projeto)

```powershell
javac -d out src/application/*.java src/ui/*.java src/model/enums/*.java src/model/entities/*.java src/model/services/*.java
```

```powershell
java -cp out application.Program
```

Se os acentos aparecerem trocados no terminal, rode `chcp 65001` antes e execute de novo.

## Exemplo de saída

Saída real do programa:

```
=== Simulador de Pulverização Seletiva ===

Mapa do talhão (6 x 10 células, 0,60 ha)
C C X X C C . C C C
C C X C C C . C C C
C C C C C C . C X C
. . . . . . . . X X
C C C C C X . C C C
C C C C X X . C C C
Legenda: . = solo | C = cultura | X = erva daninha
Quantidade: solo = 13 | cultura = 38 | erva daninha = 9
------------------------------------------
Mapa após aplicação (Pulverização total):
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
Legenda: * = célula pulverizada
Resultado - Pulverização total
  Células pulverizadas: 60
  Área pulverizada:     0,60 ha
  Calda usada:          90,00 L
  Custo:                R$ 180,00

------------------------------------------
Mapa após aplicação (Pulverização seletiva):
C C * * C C . C C C
C C * C C C . C C C
C C C C C C . C * C
. . . . . . . . * *
C C C C C * . C C C
C C C C * * . C C C
Legenda: * = célula pulverizada
Resultado - Pulverização seletiva
  Células pulverizadas: 9
  Área pulverizada:     0,09 ha
  Calda usada:          13,50 L
  Custo:                R$ 27,00

------------------------------------------
Comparação: seletiva x total
  Calda economizada:    76,50 L
  Valor economizado:    R$ 153,00
  Economia:             85,00%
```

Como 9 das 60 células têm erva daninha (15%), a seletiva usa 15% da calda, e a economia é de 85%. O separador decimal (vírgula ou ponto) depende da configuração regional do computador.

## Limitações

- O mapa é fixo, escrito direto no código.
- Os valores de litros por célula (1,5 L, equivalente a 150 L/ha) e de preço (R$ 2,00 por litro de calda) são **ilustrativos**, não vêm de dados reais.
- Não há câmera, visão computacional nem inteligência artificial: o programa já "sabe" onde está cada erva daninha.
- Todas as células têm o mesmo tamanho (10 m x 10 m).

## Próximos passos

- Gerar o mapa de forma aleatória, com densidade de erva daninha configurável.
- Menu interativo com `Scanner` para escolher tamanho do talhão e estratégia.
- Estratégia seletiva com margem de segurança (aplicar também nas células vizinhas da erva).
- Ler o mapa de um arquivo.
- Testes automatizados.

## Inspiração

A ideia vem do conceito de pulverização seletiva, que está por trás de tecnologias como o See & Spray da John Deere, em que o equipamento identifica a planta daninha e aplica o produto só onde ela está.

Este é um projeto de estudo independente, sem nenhum vínculo com a John Deere.

## Autor

Yuri Tavares — [github.com/yuritavaresx](https://github.com/yuritavaresx)

---

## Summary (English)

A console Java prototype that compares broadcast herbicide spraying (the whole field) with selective spraying (only weed cells). The field is a matrix of cells (soil, crop, weed); the program prints the map, simulates both strategies, and compares sprayed cells, area, liters, cost and savings. It shows enums, encapsulation, composition, and interface-based polymorphism (strategy pattern). Values are illustrative; there is no camera or AI. Independent study project, not affiliated with John Deere.
