# Easy News

## It is a java library for getting latest news from NewsAPI (source).

#### No need to stuck with JSON..! Here you can retrieve news by single function call..

## Prerequisites

- Add the dependencies to gradle or maven.

#### GRADLE (in Build.gradle file) - Project level

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
#### GRADLE (in Build.gradle file) - App level

```
	dependencies {
	        implementation 'com.github.Sivakumar00:EasyNews:EasyNews-1.0.1'
	}
```
#### Usage
- Get API KEY from 
  [NewsAPI](https://newsapi.org/)

- Initiate with 
```
EasyNews.intialize("API_KEY");
```
- Then, you can use provide functions

  ##### 1) Get News By Language
        It returns the list consisting of Map. (returning list<map> structure is detailed below).
  
   ```
      List<Map> list = EasyNews.getNewsByLanguage(Language.FRENCH);   //returns list<Map>
      
   ```
          Mapping keys:
                - id
                - name
                - description
                - url
                - category
                - language
                - country
                
   
   
  ##### 2) Get News By Language
  
   ```
      List<Map> list = EasyNews.getNewsByCategory(Category.ENTERTAINMENT);      //returns List<Map>
      
   ```
            Mapping keys:
                - id
                - name
                - description
                - url
                - category
                - language
                - country
   
  ##### 3) Get News By Keywords
  
  ```
       List <Map> list=EasyNews.getNewsByKeywords(query);                       //returns List<Map>
       
  ``` 
            Mapping keys:
                - author
                - title
                - description
                - url
                - urlToImage
                - publishedAt
                
  
  ##### 4) Get Headlines By Country
  
  ```
       List <Map> list=EasyNews. getHeadLinesByCountry(Country.MEXICO);         //returns List<Map>
  
  ```
            Mapping keys:
                - author
                - title
                - description
                - url
                - urlToImage
                - publishedAt
    
 ### Structure of the List<Map>:
 
 ```
      List
        [0]|--> Map(author,title,description,url,urlToImage,publishedAt)
        [1]|--> Map(author,title,description,url,urlToImage,publishedAt)
        [2]|--> Map(author,title,description,url,urlToImage,publishedAt)
         .
         .
         .
```
## Sample

  #### To access specific fields
  
  ```
    List<Map> list = EasyNews. getHeadLinesByCountry(Country.MEXICO); 
    for(Map <String,String> map : list)
    { 
        map.get("author");
        map.get("description");
        ...
    }
 ```
 [Easy News library usage sample project](https://github.com/Sivakumar00/EasyNews_Sample_Project)
 

#### Note : Create your own API key at Newsapi.org
 
 
