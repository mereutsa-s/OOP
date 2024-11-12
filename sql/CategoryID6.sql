WITH MonthlyCredit AS (
    SELECT 
        c.ClusterID,
        DATE_TRUNC('month', cr.CreditDate) AS CreditMonth,
        SUM(cr.CreditAmount) AS TotalCreditAmount
    FROM 
        Credits cr
    JOIN 
        Clusters c ON cr.ClusterID = c.ClusterID
    GROUP BY 
        c.ClusterID, 
        DATE_TRUNC('month', cr.CreditDate)
)

SELECT 
    ClusterID,
    CreditMonth,
    TotalCreditAmount,
    LAG(TotalCreditAmount) OVER (PARTITION BY ClusterID ORDER BY CreditMonth) AS PrevMonthCredit,
    COALESCE(TotalCreditAmount - LAG(TotalCreditAmount) OVER (PARTITION BY ClusterID ORDER BY CreditMonth), 0) AS Difference
FROM 
    MonthlyCredit
ORDER BY 
    ClusterID, CreditMonth;