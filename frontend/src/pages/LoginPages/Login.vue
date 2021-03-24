<template>
  <div v-if="loginError">
    <h5>Não foi possivel fazer o login... </h5>
  </div>
  <div v-else>
    <h1>
      <b-badge variant="info">Por favor faça login para acessar!</b-badge>
    </h1>
    <form @submit.prevent="callLogin()">
      <b-form-input type="text" placeholder="Usuario" class="col-md-4 mb-2" v-model="user"></b-form-input>
      <b-form-input type="password" placeholder="Senha" class="col-md-4 mb-2" v-model="password"></b-form-input>
      <b-btn variant="success" type="submit">Login</b-btn>
      Ex.: Admin, Admin
      <p v-if="error" class="error">Erro, usuario ou senha incorreta.</p>
    </form>
  </div>

</template>

<script>
export default {
  name: 'login',

  data () {
    return {
      loginError: false,
      user: '',
      password: '',
      error: false,
      errors: []
    }
  },
  methods: {
    callLogin() {
      this.errors = [];
      this.$store.dispatch('login', { user: this.user, password: this.password})
        .then(() => {
          this.$router.push('/Protected')
        })
        .catch(error => {
          this.loginError = true;
          this.errors.push(error);
          this.error = true
        })
    }
  }
}
</script>