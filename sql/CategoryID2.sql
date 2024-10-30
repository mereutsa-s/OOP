SELECT 
    c.CategoryID,
    c.CategoryName,
    SUM(p.Price * od.Quantity) AS total_profit
FROM 
    OrderDetails od
JOIN 
    Products p ON od.ProductID = p.ProductID
JOIN 
    Categories c ON p.CategoryID = c.CategoryID
JOIN 
    Orders o ON od.OrderID = o.OrderID
GROUP BY 
    c.CategoryID, c.CategoryName
ORDER BY 
    total_profit DESC;