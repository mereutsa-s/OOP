SELECT 
    c.CategoryID,
    COUNT(DISTINCT od.OrderID) AS order_count
FROM 
    OrderDetails od
JOIN 
    Products p ON od.ProductID = p.ProductID
JOIN 
    Categories c ON p.CategoryID = c.CategoryID
GROUP BY 
    c.CategoryID
ORDER BY 
    order_count DESC;