var flat = function(arr,n) {

    let result=[];


    function helper(array,depth){

        for(let item of array){

            if(Array.isArray(item) && depth>0){

                helper(item,depth-1);

            }
            else{

                result.push(item);

            }

        }

    }


    helper(arr,n);


    return result;

};