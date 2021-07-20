/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author huongnq2
 */
public class MySql {

//    177. Nth Highest Salary
//
//    CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
//BEGIN
//  DECLARE offset INT;
//  SET offset = N-1;
//  RETURN (
//      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET offset
//  );
//END
//    178. Rank Scores : ROW_NUMBER()  1 2 3 4 4  DENSE_RANK() 1 2 2 33 4 4 5 RANK() 1 2 2 4 4 6
//    SELECT
//    Score AS 'score',
//    DENSE_RANK() OVER (ORDER BY Score DESC) AS 'Rank'
//FROM
//    Scores
//ORDER BY
//    'Rank' ASC
//    180. Consecutive Numbers
//    SELECT Distinct L.Num as ConsecutiveNums
//FROM Logs as L
//INNER JOIN Logs as M ON L.num = M.num
//INNER JOIN Logs as N ON L.num = N.num
//WHERE L.Id < M.Id AND M.Id < N.Id AND M.Id -L.Id = 1 AND N.Id-M.Id = 1
//ORDER BY L.Id , N.Id ,M.Id
//    184. Department Highest Salary SELECT BOS.Department ,
//            BOS
//    .Employee ,
//            BOS
//
//    .Salary
//            FROM(
//SELECT D.Name AS 'Department',
//          E.Name AS 'Employee',
//          E.Salary AS 'Salary',
//          DENSE_RANK() OVER (PARTITION BY E.DepartmentId
//                             ORDER BY E.Salary DESC) AS 'Rank'
//   FROM Employee AS E
//   INNER JOIN Department AS D ON E.DepartmentId = D.Id) AS BOS
//WHERE BOS.Rank=1
}
