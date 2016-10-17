**Pongo** is a [template-based](http://eclipse.org/epsilon/doc/egl/) Java POJO generator for MongoDB. Instead of using low-level DBObjects to interact with your MongoDB database, with Pongo you can define your data/domain model using [Emfatic](http://www.eclipse.org/emfatic) and then generate strongly-typed Java classes you can then use to work with your database at a more convenient level of abstraction. For example, you can specify your domain model as follows:

```java
package com.googlecode.pongo.tests.blog.model;

@db
class Blog {
	val Post[*] posts;
	val Member[*] members;
	val Author[*] authors;
}

class Post {
	@searchable
	attr String title;
	attr String[*] tags;
	val Comment[*] comments;
	ref Author author;
	val Stats stats;
}

class FeaturedPost extends Post {
	attr String reason;
}

class Stats {
	attr int pageloads;
	attr int visitors;
}

class Comment {
	attr String text;
	ref Author author;
	val Comment[*] replies;
	ref Member[*] liked;
	ref Member[*] disliked;
}

class Person {
	@searchable
	attr String name;
}

class Author extends Person {

}

class Member extends Person {
	
}
```

and then use Pongo to generate code that will enable you to interact with your database as follows:

```java
public static void main(String[] args) {

	Mongo mongo = new Mongo();
	Blog blog = new Blog(mongo.getDB("blog"));

	Post post = new Post();
	post.setTitle("A post");
	
	Author author = new Author();
	author.setName("Joe Doe");
	blog.getAuthors().add(author);
	post.setAuthor(author);
	
	Comment comment = new Comment();
	comment.setText("A comment");
	post.getComments().add(comment);
	
	Comment reply = new Comment();
	reply.setText("A reply");
	comment.getReplies().add(reply);
	
	blog.getPosts().add(post);

        // Syncs with the underlying database
	blog.sync();
}
```

**Update site:** https://raw.githubusercontent.com/kolovos/pongo/master/com.googlecode.pongo.updatesite
