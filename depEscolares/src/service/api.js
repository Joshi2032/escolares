import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api",
});


export default {
  getUsuario () {
    return api.get("/usuario");
  },
  getRegistro (data) {
    return api.post("/registro", data);
  },
  iniciarSesion(email, password){
    return api.post("/login", {
      email: email,
      password: password
    });
  }
};
