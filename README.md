# SQLiteToExcel
This is a Light weight Library to Convert SQLite Database to Excel

This is a library wrapped as Gradle used for Android from the following Link
[SQLiteToExcel](https://github.com/li-yu/SQLiteToExcel)

##Featured In
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SQLite%20To%20Excel-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5221)

##How to Download
add the following library in your app level gradle file
```groovy
compile 'com.ajts.androidmads.SQLite2Excel:library:1.0.0'
```
##How to Use
###The steps to use this Library
####1.AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
####2.Library Initialization
This line is used to save the exported file in default location.
```java
SqliteToExcel sqliteToExcel = new SqliteToExcel(this, "helloworld.db");
```
This line is used to save the exported file in used preferred location.
```java
SqliteToExcel sqliteToExcel = new SqliteToExcel(this, "helloworld.db", directory_path);
```
####3.Export DB to Excel 
#####This code snippet is used to Export a single table in a database to Excel Sheet
```java
sqliteToExcel.startExportSingleTable("table1", "table1.xls", new ExportListener() {
			
	@Override
	public void onStart() {
		
	}
			
	@Override
	public void onError() {
		
	}
			
	@Override
	public void onComplete() {
		
	}
});
```

#####This code snippet is used to Export a every table in a database to Excel Sheet
```java
sqliteToExcel.startExportAllTables("helloworlddb.xls", new ExportListener() {
			
	@Override
	public void onStart() {
		
	}
			
	@Override
	public void onError() {
		
	}
			
	@Override
	public void onComplete() {
		
	}
});
```
##License
<pre>
MIT License

Copyright (c) 2017 AndroidMad / Mushtaq M A

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated<br/>documentation files (the "Software"), to deal in the Software without restriction, including without limitation<br/>the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, <br/>and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all<br/> copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT<br/>NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. <br/>IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,<br/>WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE <br/>SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
</pre>
