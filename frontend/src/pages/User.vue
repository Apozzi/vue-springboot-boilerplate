<template>
  <div class="user">
    <h1>Criar um usuário pessoa</h1>
    <h3>Apenas uma interação com banco de dados...</h3>

    <b-form-input type="text" v-model="user.firstName" class="col-md-4 mb-2" placeholder="first name"></b-form-input>
    <b-form-input type="text" v-model="user.lastName" class="col-md-4 mb-2" placeholder="last name"></b-form-input>

    <button @click="createNewUser()">Create User</button>
    <div v-if="showResponse">
      <h6>Usuario criado com id: {{ response }}</h6>
    </div>
    <button v-if="showResponse" @click="retrieveUser()">Obtido usuario {{user.id}} do banco</button>
    <h4 v-if="showRetrievedUser">
      Obtido usuario {{retrievedUser.firstName}} {{retrievedUser.lastName}}
    </h4>

  </div>
</template>

<script>
  import api from "@/api/backend-api";

  export default {
    name: 'user',

    data () {
      return {
        response: [],
        errors: [],
        user: {
          lastName: '',
          firstName: '',
          id: 0
        },
        showResponse: false,
        retrievedUser: {},
        showRetrievedUser: false
      }
    },
    methods: {
      createNewUser () {
        api.createUser(this.user.firstName, this.user.lastName).then(response => {
            this.response = response.data;
            this.user.id = response.data;
            this.showResponse = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      retrieveUser () {
        api.getUser(this.user.id).then(response => {
            this.retrievedUser = response.data;
            this.showRetrievedUser = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    }
  }

</script>
