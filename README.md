# Java Streams

## Java Stream Introduction 

A stream is a sequence of data values supporting sequential and parallel aggregate operations.

* Using aggregate functions we can sum all sales figures for a month, region or product.
* Aggregate operations work on a list of items and produces a single value.
* The result of an aggregate operation on stream may be primative value, an object or a void for Stream. 

## Collections Vs Streams
> ### Collections
> * Java Collections focus on how to store data elements for efficient access.
> #### Storage
>     Java Collection is an in-memory data structure that stores all its elements.
> #### Infinite Streams
>     Java Collection cannot reprsent a group of infinate elements

***
> ### Streams
> * Java Streams focus on aggregate operations on data elements from a data source.
> #### Storage
>     Java Streams has no storage.
>     Java stream pulls elements from a data source on-demand and passes them to a pipeline of operations for processing.
>     Java Streams we focus on operations Example (Aggregates)
>  
> #### Infinite Streams
>     Java Streams can reprsent a group of infinate elements
>     Java Streams can pull its elements from data source. The data sourse can be a collection, a function that generates data, an I/O channel, etc.
>     A Java Stream can pull data from a function which generates infinate number of elements.
> #### Reusability
>     Java Streams cannot be reusable after calling a teriminal operation.
>     To perform a computation on the same elements from the data source, we have to recrete the stream pipeline.
>     Java Streams can throw an illegalStateException in case of reusing
