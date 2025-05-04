<template>
  <nav class="dashboard">
    <div class="logo-container">
      <img src="@/assets/tecnm-removebg-preview.png" alt="logo escolar" class="logo" />
    </div>
    <div class="search-container">
      <input type="text" placeholder="Buscar..." class="search-bar" />
    </div>
    <ul class="nav-links">
      <li><a href="/alumno/inicio">Inicio</a></li>
      <li><a href="/alumno/materias">Materias</a></li>
      <li><a href="/alumno/perfil">Perfil</a></li>
    </ul>
  </nav>
</template>

<style scoped>
.dashboard {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #2196f3;
  color: white;
  padding: 0.5rem 1rem;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Adds a subtle shadow */
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
}

.logo-container {
  display: flex;
  align-items: center;
}

.logo {
  height: 40px; /* Adjust the logo size */
  width: auto;
}

.search-container {
  flex: 1; /* Allows the search bar to take available space */
  display: flex;
  justify-content: center;
  margin: 0 1rem;
}

.search-bar {
  width: 100%;
  max-width: 400px;
  padding: 0.5rem;
  border: none;
  border-radius: 8px;
  font-size: 1rem;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.nav-links {
  list-style: none;
  display: flex;
  gap: 1.5rem;
  margin: 0;
  padding: 0;
}

.nav-links a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  transition: color 0.3s ease;
}

.nav-links a:hover {
  color: #ffcc00; /* Highlight color on hover */
}
</style>