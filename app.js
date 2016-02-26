'use strict';

var express = require('express'), app = express();
var assert = require('assert');
var MongoClient = require('mongodb').MongoClient;
var url = 'mongodb://db:27017/bard';

var getQuotes = function (db, process, callback) {
  var cursor = db.collection('musings').find().sort({"quote": 1});
  cursor.toArray(function(err, docs){
    if (process !== null) {
      process(docs);
      if (callback !== null)
        callback();
    }
  });
};

app.set('views', 'views');
app.set('view engine', 'jade');

app.get('/', function(req, res) {
  MongoClient.connect(url, function(err, db) {
    getQuotes(db, function (quotes) {
        res.render('index', {quotes: quotes});
      }, function() {
        db.close();
    });
  });
});

app.listen(8080);
module.exports.getApp = app;
