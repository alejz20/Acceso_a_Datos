### Apuntes de Manejo de Conectores

<br>

###### Descripción
__________________________________
 Vamos a realizar una descripción detallada de las <strong> 
 clases (C), interfacez (I), métodos (M) , transacciones (T), poolConexión (BD)</strong>, .... 
 que vamos usamos en los ejercicios.
<br>


## ResultSet - (C)
__________________________
El **ResultSet** es una clase que proporciona información sobre los resultados de una consulta SQL.


## ResultSetMetaData - (C)
________________________
El **ResultSetMetaData** es una clase que proporciona información sobre los metadatos de un ResultSet. En otras palabras, devuelve información sobre la estructura de un conjunto
de resultados de una consulta SQL. <br>
En particular, ResultSetMetaData proporciona información sobre:

El número de columnas en el conjunto de resultados // 121<br>
El nombre de cada columna // ProdyctCode, ProductName<br>
El tipo de datos de cada columna // int<br>
La longitud de cada columna <br>
Si una columna es nullable o no



## Transacciones - (T)
________________________
Las transacciones se refiere a un conjunto de operaciones que se ejecutan de forma atómica.
esto significa que todas las operaciones  dentro de una transacción se deben completarse correctamente, o ninguna de ellas se aplicará, asegurando la integridad de los datos. (osea que no se pierda ninguno de los datos).

Ejemplo realizado en clase:
> BEGIN TRANSACTION;

> select * from country; </br>
> select * from city; </br>
> update country set country = 'Francia' where country_id = 1; </br>
> delete from city where city_id = 1; </br>
> commit;

[//]: # (### Métodos de Instancia)

[//]: # (___________________)

[//]: # (Son aquellos que pertenecen a una instancia de una clase.)

[//]: # (Es decir, son métodos que están ligados a los objetos creados a partir de esa clase.)

[//]: # (Estos métodos se pueden invocar cuando se ha creado &#40;u objeto&#41; de esa clase, y pueden acceder a los **atributos de instancia** esa clase.)

<br> 

* Método trim() en Java *  <br> 
Se utiliza para eliminar los espacios en blanco
al inicio y al final de una cadena de texto.


### Atributos de Instancia / (static) Atributos estáticos
_____________________________
Los Atributos de Instancia son simplemente variables dentro de una clase.
En cambio, los atributos estáticos son las variables declaradas con **static** que pertenecen a una clase global.


### Mapeo Dinámico
________________________
El **mapeo dinámico** es un tipo de mapeo de objetos que se usa para mapear objetos de una clase a objetos de otra clase sin estar en la clase propia.








