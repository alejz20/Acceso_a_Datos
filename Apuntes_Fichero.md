### Apuntes de Ficheros

<br>

###### Descripción
__________________________________
 Vamos a realizar una descripción detallada de las <strong> 
 clases (C), interfacez (I), métodos (M) </strong>, que vamos usamos en los ejercicios.
<br> 


##  Document -(C)
__________________________

La interfaz Documento representa el documento HTML o XML completo. Conceptualmente, es la raíz del árbol del documento y proporciona el acceso principal a los datos del documento. 
<br>
Dado que los elementos, nodos de texto, comentarios, instrucciones de procesamiento, etc. no pueden existir fuera del contexto de un Documento, la interfaz Documento también contiene los métodos de fábrica necesarios para crear estos objetos. 
<br>
Los objetos Nodo creados tienen un atributo <u> ownerDocument </u>  que los asocia al Documento en cuyo contexto fueron creados.

* Método trim() en Java *  <br> 




## DocumentBuilderFactory -(C)
________________________


##  El marshaling o marshalling -(C)
________________________

El proceso de convertir objetos a texto para compartirlos o almacenarlos en este formato.



## La Intefaz Serializable -(I)
________________________

Al implementar la interfaz Serializable...

No hay que implementar métodos. Es una interfaz que no necesita implementar métodos (marker interface).


## -()
________________________
