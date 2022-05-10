$( document ).ready(async function() {
    const response = await axios.get('http://localhost:9000/product/details');
    console.log(response);
    if(response.status==200){
let htmldata='<div class="d-flex flex-row flex-wrap">'

response.data.forEach(d=>{
	htmldata+=`<div class="card" style="width: 18rem;">  <img class="card-img-top" src="1.jpg" alt="Card image cap">  <div class="card-body">  <h5 class="card-title">${d.name}</h5>    <p class="card-text">${d.description}</p>	<p> price : ${d.unitPrice} </p>    <a href="#" class="btn btn-primary">Add to Cart</a>  </div></div>`
})

htmldata+="</div>"
document.getElementById("productcategory").innerHTML=htmldata;

       
        }
    
});