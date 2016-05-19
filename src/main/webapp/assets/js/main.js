var App = Ember.Application.create();

App.Router.map(function() {
  // index route is created by default
});

App.IndexController = Em.Controller.extend({
    actions: {
        doSearch: function() {
            var self = this;
            self.set('results', null);
            Em.$.get('/patients/search?query='+this.get('searchText')).then(function(data) {
                for (var i=0;i<data.length;i++) {
                    var docs = data[i].documents;
                    var newDocs = [];
                    for (var j=0;j<docs.length;j++) {
                        parts = docs[j].split(":::");
                        newDocs.push({
                            title: parts[0],
                            date: parts[1],
                            contents: parts[2]
                        });
                    }
                    data[i].documents = newDocs;
                }
                self.set('results', data);
            });
        } 
    }
});
