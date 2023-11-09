-- Cau 1
select * from customers LEFT join payments on c.customerNumber = p.customerNumber
where amount is null;
-- Cau 2a
select * from payments join customers on payments.customerNumber = customers.customerNumber
order by paymentdate desc
limit 10;
-- Cau 2b
select * from orders
where status != "Shipped";
-- Cau 4
select * from productlines;
select productcode, sum(qo) ans
from product p join (select productCode, sum(qo) amountOrdered
from orderdetails
group by productcode) templ on p.productCode = teml.productCode
group by productlines
order by ans desc;
-- cau 6
