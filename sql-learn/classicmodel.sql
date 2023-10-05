use classicmodels;

-- SELECT substring(productDescription, 1, 50) AS "Title of products"
-- FROM Products;

-- SELECT CONCAT(CONCAT(firstName, ' ', lastName), ', ', jobTitle) as "fullname, jobTitle"
-- FROM Employees;

-- SELECT * FROM classicmodels.productlines;
-- set sql_safe_updates = 0;
-- set FOREIGN_KEY_CHECKS = 0;
-- update productlines set productLine = replace(productLine,'Cars', 'Automobiles')

-- SELECT orderNumber, orderDate, requiredDate, shippedDate
-- FROM Orders
-- WHERE shippedDate IS NOT NULL
-- ORDER BY DATEDIFF(shippedDate, requiredDate) ASC
-- LIMIT 5;

SELECT orderNumber, orderDate, requiredDate, shippedDate
FROM orders
where month(orderDate) = 5
AND year(orderDate) = 2005
AND shippedDate IS NULL
