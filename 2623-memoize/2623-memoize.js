function memoize(fn) {

    let map = new Map();

    return function(...args){

        let key = JSON.stringify(args);

        if(map.has(key))
            return map.get(key);

        let result = fn(...args);

        map.set(key,result);

        return result;
    }
}