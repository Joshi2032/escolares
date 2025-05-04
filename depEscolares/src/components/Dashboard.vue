<script setup>
import DashboardAlumno from '../views/alumnos/dashboardAlumno.vue';
import DashboardAdmin from '../views/admins/dashboardAdmin.vue';

// Recibe el rol del usuario como prop
defineProps({
  role: {
    type: String,
    required: true,
  },
});
</script>

<template>
  <div>
    <!-- Renderiza el dashboard correspondiente según el rol -->
    <component :is="role === 'alumno' ? DashboardAlumno : DashboardAdmin" />
  </div>
</template>