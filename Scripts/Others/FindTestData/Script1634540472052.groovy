import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import java.util.stream.Collectors

import com.kms.katalon.core.testdata.TestData as TestData

TestData td = findTestData('Sign Up')

//println(td.getValue('Username', 1))

println(td.getColumnNumbers())

println(td.getRowNumbers())

List<String> email = td.getAllData().get(1)
println email
/*
 * for (def row : (1..td.getRowNumbers())) { println("#${row}") for (def col :
 * (1..td.getColumnNumbers())) { data = td.getValue(col, row)
 * System.out.println(data) } }
 */

List<String> productList = td.getAllData().stream()
.map{data -> data[0]}/*get first column of each row in data file */
.collect(Collectors.toList())/*add collect and parse to list*/
println productList
