var compactObject = function(obj) {

    if(Array.isArray(obj)){

        return obj
        .filter(Boolean)
        .map(compactObject);

    }


    if(typeof obj === "object" && obj !== null){

        let result={};

        for(let key in obj){

            let value = compactObject(obj[key]);

            if(value)
                result[key]=value;
        }

        return result;
    }


    return obj;
};