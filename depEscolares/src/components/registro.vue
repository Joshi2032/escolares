<template>
  <div class="registro-container">
    <div class="card">
      <h1>Registro</h1>
      <form @submit.prevent="submitForm">
        <div 
          v-for="(field, key) in formFields" 
          :key="key" 
          class="form-group"
        >
          <label :for="key">{{ field.label }}</label>
          <input 
            :type="field.type" 
            :id="key" 
            v-model="form[key]" 
            :placeholder="field.placeholder" 
            :required="field.required"
          />
        </div>
        <button type="submit">Registrar</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        nombre: '',
        email: '',
        password: ''
      },
      formFields: {
        nombre: { label: 'Nombre:', type: 'text', placeholder: 'Ingresa tu nombre', required: true },
        email: { label: 'Email:', type: 'email', placeholder: 'Ingresa tu email', required: true },
        password: { label: 'Contraseña:', type: 'password', placeholder: 'Ingresa tu contraseña', required: true }
      }
    };
  },
  methods: {
    submitForm() {
      console.log('Formulario enviado:', this.form);
    }
  }
};
</script>

<style scoped>
.registro-container {
  background: linear-gradient(135deg, #1e88e5, #42a5f5) !important;
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
  color: #fff;
}

h1 {
  margin-bottom: 20px;
  font-size: 2.8rem;
  text-align: center;
  text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
  color: black; /* Changed to yellow for better contrast */
}

.card {
  background: #ffffff;
  border-radius: 20px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
  padding: 40px;
  width: 100%;
  max-width: 400px;
  box-sizing: border-box;
  text-align: center;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.3);
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
  color: #333;
  font-size: 1.2rem;
}

input {
  width: 100%;
  padding: 14px;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-sizing: border-box;
  font-size: 1rem;
  transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

input:focus {
  border-color: #42a5f5;
  outline: none;
  box-shadow: 0 0 10px rgba(66, 165, 245, 0.5);
}

button {
  width: 100%;
  padding: 14px;
  background-color: #1e88e5;
  color: white;
  border: none;
  border-radius: 10px;
  cursor: pointer;
  font-size: 1.2rem;
  font-weight: bold;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

button:hover {
  background-color: #1565c0;
  transform: scale(1.03);
}

button:active {
  background-color: #0d47a1;
  transform: scale(0.98);
}
</style>