<template>
  <nav class="dashboard">
    <ul>
      <li><a href="/admin/inicio">Inicio</a></li>
      <li><a href="/admin/usuarios">Usuarios</a></li>
      <li><a href="/admin/configuracion">Configuración</a></li>
    </ul>
  </nav>
</template>

<style scoped>
.dashboard {
  background-color: #4caf50;
  color: white;
  padding: 1rem;
}
.dashboard ul {
  list-style: none;
  display: flex;
  gap: 1rem;
}
.dashboard a {
  color: white;
  text-decoration: none;
}
.dashboard a:hover {
  text-decoration: underline;
}
</style>