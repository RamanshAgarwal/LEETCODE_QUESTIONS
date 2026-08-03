var TimeLimitedCache = function() {

    this.cache = new Map();

};

TimeLimitedCache.prototype.set = function(key,value,duration){

    let existed=this.cache.has(key);

    clearTimeout(this.cache.get(key)?.timer);


    let timer=setTimeout(()=>{
        this.cache.delete(key);
    },duration);


    this.cache.set(key,{value,timer});

    return existed;

};


TimeLimitedCache.prototype.get=function(key){

    if(this.cache.has(key))
        return this.cache.get(key).value;

    return -1;

};


TimeLimitedCache.prototype.count=function(){

    return this.cache.size;

};