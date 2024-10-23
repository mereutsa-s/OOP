-- 1. Количество уникальных стран среди клиентов
SELECT COUNT(DISTINCT Country) AS UniqueCountries
FROM Customers;

-- 2. Количество клиентов, проживающих в Бразилии
SELECT COUNT(*) AS ClientsInBrazil
FROM Customers
WHERE Country = 'Бразилия';

-- 3. Средняя цена и общее количество товаров в категории с идентификатором 5
SELECT AVG(Price) AS AveragePrice, COUNT(*) AS TotalProducts
FROM Products
WHERE CategoryID = 5;

-- 4. Средний возраст сотрудников на дату 2024-01-01
SELECT AVG(JULIANDAY('2024-01-01') - JULIANDAY(BirthDate)) AS AverageAge
FROM Employees;

-- 5. Заказы, сделанные в период с 16 января по 15 февраля 2024 года, отсортированные по дате заказа
SELECT *
FROM Orders
WHERE OrderDate BETWEEN '2024-01-16' AND '2024-02-15'
ORDER BY OrderDate;

-- 6. Количество заказов, сделанных в ноябре 2023 года
SELECT COUNT(*) AS NovemberOrders
FROM Orders
WHERE OrderDate >= '2023-11-01' AND OrderDate < '2023-12-01';

-- 7. Количество заказов за январь 2024 года с использованием оператора LIKE
SELECT COUNT(*) AS JanuaryOrders
FROM Orders
WHERE strftime('%Y-%m', OrderDate) LIKE '2024-01%';

-- 8. Количество заказов за 2024 год с использованием функции STRFTIME
SELECT COUNT(*) AS Orders2024
FROM Orders
WHERE STRFTIME('%Y', OrderDate) = '2024';