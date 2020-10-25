package calc;

interface Expression
{
    public int valeur();
    public String toString();
}

/**
 *
@startuml
skinparam class {
	BackgroundColor DeepSkyBlue
	ArrowColor SeaGreen
	BorderColor DarkBlue
}
skinparam stereotypeCBackgroundColor YellowGreen

interface Expression {
  int valeur()
  String toString()
}

abstract class Binaire {
  Expression gauche
  Expression droite
  String toString()
  String getOperateur()
}

abstract class Fonction {
  Expression gauche
  Expression droite
  String toString()
  String getOperateur()
}

class Nombre {
  int val
  int valeur()
  String toString()
}


Expression<|.. Binaire
Expression<|.. Fonction
Expression<|.. Nombre
Binaire <|-- Somme
Binaire <|-- Difference
Binaire <|-- Produit
Binaire <|-- Quotient
Fonction <|-- Min
Fonction <|-- Max
Fonction <|-- Moyenne
Binaire -up- "2" Expression
Fonction -up- "2" Expression

class Somme {
  int valeur()
  String getOperateur()
}

class Min{
  int valeur()
  String getOperateur()
}

class Moyenne{
  int valeur()
  String getOperateur()
}

class Max{
  int valeur()
  String getOperateur()
}

class Difference{
  int valeur()
  String getOperateur()
}

class Produit{
  int valeur()
  String getOperateur()
}

class Quotient{
  int valeur()
  String getOperateur()
}
@enduml
 */