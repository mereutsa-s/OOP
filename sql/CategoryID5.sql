WITH AvgCredit AS (
    SELECT 
        c.ClusterID,
        DATE_TRUNC('month', cr.CreditDate) AS CreditMonth,
        AVG(cr.CreditAmount) AS AvgCreditAmount
    FROM 
        Credits cr
    JOIN 
        Clusters c ON cr.ClusterID = c.ClusterID
    GROUP BY 
        c.ClusterID, 
        DATE_TRUNC('month', cr.CreditDate)
),
MaxCredit AS (
    SELECT 
        DATE_TRUNC('month', cr.CreditDate) AS CreditMonth,
        MAX(cr.CreditAmount) AS MaxCreditAmount
    FROM 
        Credits cr
    GROUP BY 
        DATE_TRUNC('month', cr.CreditDate)
)

SELECT 
    ac.ClusterID,
    ac.CreditMonth,
    ac.AvgCreditAmount,
    mc.MaxCreditAmount
FROM 
    AvgCredit ac
JOIN 
    MaxCredit mc ON ac.CreditMonth = mc.CreditMonth
ORDER BY 
    ac.CreditMonth, ac.ClusterID;