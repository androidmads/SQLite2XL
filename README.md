# SQLiteToExcel
This is a Light weight Library to Convert SQLite Database to Excel

This is a library wrapped as Gradle used for Android from the following Link
[SQLiteToExcel](https://github.com/li-yu/SQLiteToExcel)

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
ste.startExportAllTables("helloworlddb.xls", new ExportListener() {
			
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
