<script setup>
import { RouterLink, RouterView } from 'vue-router';
import { ref } from 'vue';
import Dashboard from './components/Dashboard.vue';

// Simula el rol del usuario (puedes reemplazarlo con un sistema de autenticación real)
const userRole = ref('alumno'); // Cambia a 'admin' para probar el dashboard de administrador
</script>

<template>
  <header class="dashboard-container">
    <Dashboard :role="userRole" />
  </header>
  
  <div class="app-container">
    <RouterView />
  </div>
</template>

<style>
/* Fija el dashboard en la parte superior */
.dashboard-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000; /* Asegura que esté por encima de otros elementos */
  background-color: #ffffff; /* Fondo blanco para que destaque */
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Sombra para separar visualmente */
  height: 60px; /* Altura fija del dashboard */
  display: flex;
  align-items: center; /* Centra verticalmente el contenido del dashboard */
  justify-content: space-between; /* Espacia los elementos dentro del dashboard */
}

/* Ajusta el contenedor principal para que no se superponga con el dashboard */
.app-container {
  display: flex;
  flex-direction: column; /* Asegura que los elementos se organicen en columna */
  justify-content: center;
  align-items: center;
  height: calc(100vh - 60px); /* Resta la altura del dashboard */
  width: 100%;
  background: linear-gradient(135deg, #2196f3, #64b5f6) !important;
  padding: 0; /* Elimina el padding adicional */
  box-sizing: border-box;
  overflow: auto; /* Asegura que el contenido adicional sea desplazable */
}

/* Estilo para las vistas dentro del RouterView */
.app-container > * {
  flex: 1; /* Asegura que los hijos ocupen el espacio disponible */
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* Estilos globales opcionales */
body {
  margin: 0;
  font-family: Arial, sans-serif;
  overflow: hidden; /* Evita scroll innecesario en la página */
}
</style>
