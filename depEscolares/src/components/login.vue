<template>
    <div class="login-container">
      <div class="login-card">
        <h1>Bienvenido a escolares!</h1>
        <h2>Iniciar Sesión</h2>
        <form @submit.prevent="handleLogin" novalidate>
          <div class="form-group">
            <label for="email">Correo Electrónico</label>
            <input
              type="email"
              id="email"
              v-model.trim="email"
              placeholder="Ingresa tu correo"
              required
              aria-label="Correo Electrónico"
              aria-describedby="emailHelp"
            />
            <small id="emailHelp" class="form-text">Nunca compartiremos tu correo electrónico.</small>
          </div>
          <div class="form-group">
            <label for="password">Contraseña</label>
            <input
              type="password"
              id="password"
              v-model.trim="password"
              placeholder="Ingresa tu contraseña"
              required
              aria-label="Contraseña"
            />
          </div>
          <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
          <button type="submit" class="login-button">Ingresar</button>
          <div class="form-group">
            <small>¿Olvidaste tu contraseña? <a href="#">Recuperar</a></small>
          </div>
          <div class="form-group">
            <small>¿No tienes cuenta? <a href="#">Registrarse</a></small>
          </div>
          <div class="form-group">
            <small>Iniciar sesión con:</small>
            <button type="button" class="login-button" style="background: #3b5998;">Facebook</button>
            <button type="button" class="login-button" style="background: #db4437;">Google</button>
            <button type="button" class="login-button" style="background: #1da1f2;">Twitter</button>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: "",
        password: "",
        errorMessage: "",
      };
    },
    methods: {
      handleLogin() {
        if (!this.email || !this.password) {
          this.errorMessage = "Por favor, completa todos los campos.";
          return;
        }
        this.errorMessage = "";
        // Aquí puedes agregar la lógica para manejar el inicio de sesión
        console.log("Email:", this.email);
        console.log("Password:", this.password);
      },
    },
  };
  </script>
  
  <style scoped>
  /* Contenedor principal */
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: calc(100vh - 60px); /* Resta la altura del dashboard */
    margin-top: 60px; /* Asegura que el contenido no se superponga con el dashboard */
    background: linear-gradient(135deg, #2196f3, #64b5f6);
    padding: 1.5rem;
    box-sizing: border-box;
    font-family: 'Roboto', sans-serif;
  }
  
  /* Tarjeta de login */
  .login-card {
    background: #ffffff;
    padding: 3rem;
    border-radius: 20px;
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
    width: 100%;
    max-width: 400px;
    text-align: center;
    animation: fadeIn 0.5s ease-in-out;
    border: 1px solid #e0e0e0;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
  }
  
  .login-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 20px 40px rgba(0, 0, 0, 0.25);
  }
  
  /* Títulos */
  h1 {
    margin-bottom: 1rem;
    color: #1565c0;
    font-size: 2.5rem;
    font-weight: 700;
    letter-spacing: 1px;
  }
  
  h2 {
    margin-bottom: 2rem;
    color: #1e88e5;
    font-size: 2rem;
    font-weight: 600;
    letter-spacing: 0.5px;
  }
  
  /* Grupo de formulario */
  .form-group {
    margin-bottom: 1.5rem;
    text-align: left;
  }
  
  label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: 600;
    color: #0d47a1;
    font-size: 1rem;
  }
  
  input {
    width: 100%;
    padding: 0.9rem;
    border: 1px solid #ddd;
    border-radius: 12px;
    font-size: 1rem;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
    background: #f9f9f9;
  }
  
  input:focus {
    outline: none;
    border-color: #42a5f5;
    box-shadow: 0 0 10px rgba(66, 165, 245, 0.5);
  }
  
  /* Mensaje de error */
  .error-message {
    color: #d32f2f;
    margin-bottom: 1rem;
    font-size: 0.95rem;
    font-weight: bold;
    text-align: left;
  }
  
  /* Botón de login */
  .login-button {
    width: 100%;
    padding: 1rem;
    background: linear-gradient(135deg, #42a5f5, #1e88e5);
    color: #fff;
    border: none;
    border-radius: 12px;
    font-size: 1.2rem;
    font-weight: 600;
    cursor: pointer;
    transition: background 0.3s ease, transform 0.2s ease, box-shadow 0.2s ease;
  }
  
  .login-button:hover {
    background: linear-gradient(135deg, #1e88e5, #1565c0);
    transform: translateY(-3px);
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
  }
  
  .login-button:active {
    transform: translateY(0);
  }
  
  /* Botones de redes sociales */
  .login-button[style] {
    margin-top: 0.5rem;
    font-size: 1rem;
    border-radius: 10px;
    transition: transform 0.2s ease, box-shadow 0.2s ease;
  }
  
  .login-button[style]:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
  }
  
  /* Enlaces */
  a {
    color: #1e88e5;
    text-decoration: none;
    font-weight: 500;
    transition: color 0.3s ease;
  }
  
  a:hover {
    color: #1565c0;
    text-decoration: underline;
  }
  
  /* Texto pequeño */
  small {
    font-size: 0.9rem;
    color: #555;
  }
  
  /* Animación de entrada */
  @keyframes fadeIn {
    from {
      opacity: 0;
      transform: translateY(-20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }
  
  /* Estilos responsivos */
  @media (max-width: 480px) {
    .login-card {
      padding: 2rem;
    }
  
    h1 {
      font-size: 2rem;
    }
  
    h2 {
      font-size: 1.8rem;
    }
  
    .login-button {
      font-size: 1rem;
    }
  }
  </style>
