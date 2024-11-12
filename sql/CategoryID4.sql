WITH AvgPrices AS (
    SELECT 
        p.CategoryID,
        p.ProductID,
        p.ProductName,
        AVG(p.Price) AS AvgPrice
    FROM 
        Products p
    JOIN 
        OrderDetails od ON p.ProductID = od.ProductID
    GROUP BY 
        p.CategoryID, 
        p.ProductID, 
        p.ProductName
)

SELECT 
    CategoryID,
    ProductID,
    ProductName,
    AvgPrice,
    RANK() OVER (PARTITION BY CategoryID ORDER BY AvgPrice DESC) AS ProductRank
FROM 
    AvgPrices
ORDER BY 
    CategoryID, ProductRank;