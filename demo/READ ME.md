# Demo

This is a small demo showing the use of pagination.

You can try visit these links to see pagination and sorting in action:

1. [humans](https://aws-rds-humans.herokuapp.com/humans)
2. [humans?sort=age](https://aws-rds-humans.herokuapp.com/humans?sort=age)
3. [humans?sort=age&sort=name](https://aws-rds-humans.herokuapp.com/humans?sort=age&sort=name)
4. [humans?sort=age&sort=name&page=3](https://aws-rds-humans.herokuapp.com/humans?sort=age&sort=name&page=3)
4. [humans?sort=age&sort=name&page=2&size=7](https://aws-rds-humans.herokuapp.com/humans?sort=age&sort=name&page=2&size=7)

Also, you can see in the __HumanController__, the method __save __@Valid__

Entities are stored in different schemas, meaning same database, but in "buckets", easier to categorize them.

The demo does not contain services, 
