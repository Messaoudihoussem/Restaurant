import React, { useState, useEffect } from "react";
import './App.css';
import axios from "axios";
import logo from './chilis-logo.png';
import bg from './bg.JPG'

console.log(logo);
console.log(bg);
const App = () => {
  const url = "http://localhost:9090/api/getAllItems";
  const [data, setData] = useState([]);

  const fetchInfo = () => {
    return axios.get(url).then((res) => setData(res.data));
  };

  useEffect(() => {
    fetchInfo();
  }, []);
  return (

  <main>
<section className="bg">
  <div class="container">
   <img src={bg} className="bg1"></img>
   <div class="centered">
   <table>
<tbody>
  <tr>
    <td align="left">
      chilis tn
    </td>
  </tr>
<tr>
    <td><div className="introtext">Découvrez les
meilleures recettes
syriennes </div></td>
</tr>
<tr>
    <td><div className="btnmenu">
      <a href='#sectionmenu' class="menubtn">Voir Notre Menu</a>
      </div>
      </td>
</tr>

</tbody>
</table>
    </div>
   </div>
</section>




    <section className="menu section">
      <div className="title">
        <h2>Notre Menu</h2>
        <div className="underline"></div>
      </div>
      <div className="title2" id="sectionmenu">
        <p>
          Nos Fajitas
        </p>
        
      </div>
      {/* <Menu items={menuItems} />    */}
      <div className="section-center">
      {data.map((item) => {
        const { id, title, img, price } = item;
        return (
          <article key={id} className="menu-item">
            <img src={img} alt={title} className="photo" />
            <div className="item-info">
              <header>
                <h2>{title}</h2>
              </header>
              <h4 className="price">{price} DT</h4>
            </div>
          </article>
        );
      })}
    </div>
      <div className="more">
      <a href="index.html">
          Voir Plus
          </a>
      </div>

      <div className="title2">
        <p1>
          Nos Fajitas
        </p1>
        
      </div>
      {/* <Menu items={menuItems} />    */}
      <div className="section-center">
      {data.map((item) => {
        const { id, title, img, price } = item;
        return (
          <article key={id} className="menu-item">
            <img src={img} alt={title} className="photo" />
            <div className="item-info">
              <header>
                <h2>{title}</h2>
              </header>
              <h4 className="price">{price} DT</h4>
            </div>
          </article>
        );
      })}
    </div>
      <div className="more">
      <a href="index.html">
          Voir Plus
          </a>
      </div>

    </section>
  <section className="menu section">
      <div className="contact">
          
    <div className="labelcontact">
      Prender Conatct
    </div>
      <table>

    <tbody>
    <tr>
        <td>
          <form className="form-box"> 
            <div className = "field1">
            <input placeholder="Nom et Prénom"/>        
            <input placeholder="Adresse Email"/>
            <textarea placeholder="Votre message ici..."/>
            </div>
            <button type = "submit" id= "submitBtn"> Envoyer</button>
        </form>
        </td>
        <td><img src={logo} className="img"></img></td>
    </tr>
    </tbody>
</table>

</div>
</section>
      
  </main>
  );
}

export default App;
