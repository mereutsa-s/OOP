SELECT 
    c.CategoryID,
    SUM(od.Quantity) AS total_quantity,
    SUM(od.Quantity * od.UnitPrice) AS total_revenue
FROM 
    OrderDetails od
JOIN 
    Products p ON od.ProductID = p.ProductID
JOIN 
    Categories c ON p.CategoryID = c.CategoryID
GROUP BY 
    c.CategoryID
ORDER BY 
    total_revenue DESC;