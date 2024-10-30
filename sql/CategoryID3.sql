SELECT 
    EXTRACT(YEAR FROM o.OrderDate) AS order_year,
    EXTRACT(MONTH FROM o.OrderDate) AS order_month,
    c.Country,
    COUNT(o.OrderID) AS order_count
FROM 
    Orders o
JOIN 
    Customers c ON o.CustomerID = c.CustomerID
GROUP BY 
    order_year, order_month, c.Country
ORDER BY 
    order_year, order_month, c.Country;