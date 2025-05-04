<template>
    <div class="login-container">
      <div class="login-card">
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
    min-height: 100vh;
    background: linear-gradient(135deg, #e3f2fd, #bbdefb);
    padding: 1rem;
    box-sizing: border-box;
  }
  
  /* Tarjeta de login */
  .login-card {
    background: #ffffff;
    padding: 2rem;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
    width: 100%;
    max-width: 400px;
    text-align: center;
    animation: fadeIn 0.5s ease-in-out;
    border: 1px solid #e0e0e0;
  }
  
  /* Título */
  h2 {
    margin-bottom: 1.5rem;
    color: #1565c0;
    font-size: 1.8rem;
    font-weight: bold;
  }
  
  /* Grupo de formulario */
  .form-group {
    margin-bottom: 1.25rem;
    text-align: left;
  }
  
  label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: bold;
    color: #1565c0;
    font-size: 0.95rem;
  }
  
  input {
    width: 100%;
    padding: 0.85rem;
    border: 1px solid #ddd;
    border-radius: 8px;
    font-size: 1rem;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
  }
  
  input:focus {
    outline: none;
    border-color: #2196f3;
    box-shadow: 0 0 6px rgba(33, 150, 243, 0.5);
  }
  
  /* Mensaje de error */
  .error-message {
    color: #d32f2f;
    margin-bottom: 1rem;
    font-size: 0.9rem;
  }
  
  /* Botón de login */
  .login-button {
    width: 100%;
    padding: 0.85rem;
    background: linear-gradient(135deg, #2196f3, #1976d2);
    color: #fff;
    border: none;
    border-radius: 8px;
    font-size: 1.1rem;
    font-weight: bold;
    cursor: pointer;
    transition: background 0.3s ease, transform 0.2s ease, box-shadow 0.2s ease;
  }
  
  .login-button:hover {
    background: linear-gradient(135deg, #1976d2, #1565c0);
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
  }
  
  .login-button:active {
    transform: translateY(0);
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
      padding: 1.5rem;
    }
  
    h2 {
      font-size: 1.5rem;
    }
  
    .login-button {
      font-size: 1rem;
    }
  }
  </style>
  